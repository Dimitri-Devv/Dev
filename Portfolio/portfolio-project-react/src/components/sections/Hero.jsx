import { VideoText } from "@/components/ui/video-text";
import Video from "@/assets/Hero.mp4";
import codingVideo from "@/assets/codingVideo.mp4";
import { Button } from "@/components/ui/button.jsx";
import {AuroraText} from "@/components/ui/titre.jsx";

const Hero = () => {
    return (
        <div className="relative h-screen w-full overflow-hidden">
            <video
                src={Video}
                autoPlay
                loop
                muted
                playsInline
                onLoadedMetadata={(e) => {
                    e.currentTarget.currentTime = 2;
                }}
                className="
  absolute inset-0 h-full w-full object-cover scale-[1.05] opacity-30
  mask-[radial-gradient(ellipse_at_center,rgba(0,0,0,1)_58%,rgba(0,0,0,0.85)_70%,rgba(0,0,0,0.35)_84%,rgba(0,0,0,0)_100%)]
  [-webkit-mask-image:radial-gradient(ellipse_at_center,rgba(0,0,0,1)_58%,rgba(0,0,0,0.85)_70%,rgba(0,0,0,0.35)_84%,rgba(0,0,0,0)_100%)]
"
            />
            <div className="absolute inset-0 bg-black/40" />
            <div
              className="pointer-events-none absolute bottom-0 left-0 w-full h-100
                         bg-linear-to-b from-transparent via-black/60 to-black"
            />

            <div className="relative z-10 flex h-full items-center">
                <div className="mx-auto w-full max-w-7xl px-6">
                    <div className="flex flex-col items-center justify-center text-center gap-8">

                        <div className="flex flex-col gap-5 text-center items-center">
                            <div className="relative w-full h-35 md:h-45 lg:h-55">
                                <AuroraText className="text-center">
                                    PORTFOLIO
                                </AuroraText>
                            </div>
                            <h3 className="text-accent text-xl ">Bonjour, je m'appelle Ricquier Dimitri</h3>
                            <p className="textSecondary max-w-2xl leading-relaxed text-center">
                                Je conçois des expériences web modernes, performantes
                                et élégantes, avec une forte attention au détail.
                            </p>

                            <div className="flex flex-wrap gap-4">
                                <Button size="lg" className="cursor-pointer">
                                    Découvrir mon profil
                                </Button>

                                <Button variant="outline" size="lg" className="cursor-pointer">
                                    Me contacter
                                </Button>
                            </div>
                        </div>



                    </div>
                </div>
            </div>
        </div>
        );
};

export default Hero;