import { Canvas, useFrame } from "@react-three/fiber";
import { useGLTF, Environment, OrbitControls } from "@react-three/drei";
import { Suspense, useRef, useEffect } from "react";
import * as THREE from "three";

function Model() {
    const group = useRef();
    const { scene } = useGLTF("/avatar/boy.glb");

    const rightArm = useRef();
    const rightForeArm = useRef();
    const rightHand = useRef();

    const leftArm = useRef();
    const leftForeArm = useRef();

    const head = useRef();
    const neck = useRef();
    const leftEye = useRef();
    const rightEye = useRef();

    useEffect(() => {
        scene.traverse((obj) => {
            if (obj.isBone) {
                const name = obj.name.toLowerCase();
                if (name.includes("rightarm")) rightArm.current = obj;
                if (name.includes("rightforearm") || name.includes("lowerarm")) rightForeArm.current = obj;
                if (name.includes("righthand") || name.includes("hand_r")) rightHand.current = obj;

                if (name.includes("leftarm")) leftArm.current = obj;
                if (name.includes("leftforearm") || name.includes("lowerarm_l")) leftForeArm.current = obj;

                if (name.includes("head")) head.current = obj;
                if (name.includes("neck")) neck.current = obj;
                if (name.includes("lefteye")) leftEye.current = obj;
                if (name.includes("righteye")) rightEye.current = obj;
            }

            if (obj.isSkinnedMesh) {
                obj.frustumCulled = false;
            }
        });
    }, [scene]);

    useFrame(({ clock, pointer }) => {
        const t = clock.getElapsedTime();
        const cycle = 5.5; // slightly slower loop
        const phase = (t % cycle) / cycle; // 0 → 1

        const waveAmount = THREE.MathUtils.clamp(
            THREE.MathUtils.smoothstep(
                phase < 0.22
                    ? phase / 0.16        // smoother raise
                    : phase > 0.70
                        ? (1 - phase) / 0.22 // smoother return
                        : 1,
                0,
                1
            ),
            0,
            1
        );

        // Organic timing offsets (anticipation / follow-through)
        const waveFast = THREE.MathUtils.smoothstep(waveAmount, 0, 1);
        const waveDelayed = THREE.MathUtils.smoothstep(
            THREE.MathUtils.clamp(waveAmount - 0.15, 0, 1),
            0,
            1
        );

        // 🫁 Idle breathing + natural body sway
        if (group.current) {
            group.current.position.y = -1.2 + Math.sin(t * 2) * 0.02;
            group.current.rotation.y = Math.sin(t * 1.2) * (0.04 + waveAmount * 0.05);
            group.current.rotation.x =
                Math.sin(t * 1.5) * waveDelayed * 0.035;
        }

        // 👀 Head & eyes follow mouse (natural, limited)
        // pointer.y = -1 (bas écran) → tête vers le bas
        const lookX = THREE.MathUtils.clamp(-pointer.y * 0.8, -0.6, 0.45);
        const lookY = THREE.MathUtils.clamp(pointer.x * 0.8, -0.6, 0.6);

        if (neck.current) {
            neck.current.rotation.x = THREE.MathUtils.lerp(
                neck.current.rotation.x,
                lookX * 0.35,
                0.06
            );
            neck.current.rotation.y = THREE.MathUtils.lerp(
                neck.current.rotation.y,
                lookY * 0.35,
                0.06
            );
        }

        if (head.current) {
            head.current.rotation.x = THREE.MathUtils.lerp(
                head.current.rotation.x,
                lookX,
                0.08
            );
            head.current.rotation.y = THREE.MathUtils.lerp(
                head.current.rotation.y,
                lookY,
                0.08
            );
        }

        if (leftEye.current && rightEye.current) {
            leftEye.current.rotation.y = lookY * 0.6;
            rightEye.current.rotation.y = lookY * 0.6;
        }

        // Upper arm (shoulder reacts slightly to wave)
        if (rightArm.current) {
            // Arm closer to torso (natural human pose)
            const restX = 1.1;
            const restZ = -0.15;

            const waveX = -0.6;
            const waveZ = -0.65;

            rightArm.current.rotation.x = THREE.MathUtils.lerp(restX, waveX, waveAmount);
            rightArm.current.rotation.z = THREE.MathUtils.lerp(restZ, waveZ, waveAmount);
            // shoulder naturally lifts & opens during wave
            rightArm.current.rotation.y = -0.15 * waveFast;
        }

        // Left arm stays down near torso (natural rest pose)
        if (leftArm.current) {
            const restX = 1.2;     // arm down
            const restZ = 0.25;     // close to body (left side is mirrored)

            // very subtle reactive motion only during wave
            leftArm.current.rotation.x =
                restX + Math.sin(t * 2) * 0.015 * waveAmount;
            leftArm.current.rotation.z =
                restZ + Math.sin(t * 1.5) * 0.02 * waveAmount;
        }

        if (leftForeArm.current) {
            leftForeArm.current.rotation.x = 0.05; // relaxed elbow
        }

        // Forearm (elbow ~90° + REAL waving motion)
        if (rightForeArm.current) {
            const restX = 0.05;
            const waveX = -1.5;

            rightForeArm.current.rotation.x =
                THREE.MathUtils.lerp(restX, waveX, waveDelayed);

            if (waveAmount > 0.01) {
                rightForeArm.current.rotation.z = Math.sin(t * 10) * 0.5 * waveAmount;
            } else {
                rightForeArm.current.rotation.z = 0;
            }

            // slight backward rotation for natural anatomy
            rightForeArm.current.rotation.y = THREE.MathUtils.lerp(
                rightForeArm.current.rotation.y,
                 waveAmount,
                0.20
            );
        }

        // Hand (palm facing camera + wrist wave)
        if (rightHand.current) {
            const restX = 0;
            const restY = 0;
            const restZ = 0;

            const baseX = -0.15;
            const baseY = Math.PI;
            const baseZ = 0.45;


            rightHand.current.rotation.x = THREE.MathUtils.lerp(restX, baseX, waveAmount);
            rightHand.current.rotation.y = THREE.MathUtils.lerp(restY, baseY, waveAmount);


            const wristWave = Math.sin(t * 10) * 0.35 * waveDelayed;
            rightHand.current.rotation.z =
                THREE.MathUtils.lerp(restZ, baseZ, waveAmount) + wristWave;
        }
    });

    return (
        <primitive
            ref={group}
            object={scene}
            scale={1.2}
            rotation={[0, Math.PI, 0]}
        />
    );
}

export default function Avatar3D() {
    return (
        <div className="relative z-10 w-30 h-80 md:w-60 md:h-190 lg:w-100 lg:h-200">
            <Canvas
                className="relative! z-0!"
                camera={{ position: [0, 1.2, 3.5], fov: 38 }}
            >
                <ambientLight intensity={0.01} />
                <directionalLight position={[2, 3, 2]} intensity={0.1} />

                <Environment preset="city" />

                <Suspense fallback={null}>
                    <Model />
                </Suspense>

                <OrbitControls
                    enableZoom={false}
                    enableRotate={false}
                    enablePan={false}
                />
            </Canvas>
        </div>
    );
}