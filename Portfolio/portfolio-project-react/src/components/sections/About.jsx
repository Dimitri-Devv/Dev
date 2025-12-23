import { useState } from "react";
import Avatar3D from "@/components/Avatar3D.jsx";
import { TypingAnimation } from "@/components/ui/typing-animation";
import {AuroraText} from "@/components/ui/titre.jsx";
import { RainbowButton } from "@/components/ui/rainbow-button"

const answers = {
    prenom: "Je m'appelle Dimitri",
    age: "J’ai 23 ans.",
    parcours:
        "J’ai suivi un BTS SIO (Services Informatiques aux Organisations), une formation orientée développement et informatique d’entreprise. Aujourd’hui, je me spécialise dans le développement web moderne.",
    passion:
        "Je suis passionné par le développement web, en particulier la création d’interfaces modernes, interactives et performantes.",
};

const Questions = ["Ton prenom ?", "Ton âge ?", "Ton parcours ?", "Tes passions ?"];

const About = () => {
    const [message, setMessage] = useState(
        "Salut ! \nTu peux me poser une question à l’aide des boutons."
    );

    return (
        <section
          id="about"
          className="relative flex flex-col min-h-screen pt-30 pb-32 lg:mb-50 background overflow-hidden"
        >

          <div className="absolute inset-0 z-0 pointer-events-none">
            <img
              src="/avatar/img_1.png"
              alt="Background scene"
              className="h-full w-full object-cover object-center opacity-100 saturate-125 contrast-110 brightness-90 md:object-center lg:object-[center_60%]"
            />

            <div className="absolute top-0 left-0 right-0 h-[25vh] md:h-[30vh] bg-gradient-to-b from-black via-black to-black/10" />

            <div className="absolute bottom-0 left-0 right-0 h-[45vh] md:h-[55vh] lg:h-[65vh] bg-gradient-to-t from-black via-black/70 to-transparent" />


            <div className="absolute inset-0 bg-[radial-gradient(ellipse_at_center,rgba(0,0,0,0)_0%,rgba(0,0,0,0.55)_55%,rgba(0,0,0,0.85)_100%)]" />

            <div className="absolute inset-0 opacity-60 mix-blend-screen bg-[radial-gradient(900px_circle_at_22%_78%,rgba(124,58,237,0.16),transparent_55%),radial-gradient(900px_circle_at_78%_22%,rgba(56,189,248,0.12),transparent_55%),radial-gradient(700px_circle_at_60%_45%,rgba(212,175,55,0.08),transparent_60%)]" />
          </div>

            <div className="w-full flex flex-col items-center text-center mb-20">
                <AuroraText>
                   Qui suis-je
                </AuroraText>
            </div>
            <div
              className="
                relative z-10
                px-5
                grid
                grid-cols-1
                gap-10
                md:flex
                md:items-center
                md:gap-12
                md:px-0
                md:mr-4
                ml-0 md:ml-10 lg:ml-50
                lg:justify-center
              "
            >
              <div className="grid grid-cols-2 items-center gap-6 md:flex md:gap-25">
                <div className="flex flex-col gap-8">
                  {Questions.map((question, index) => (
                    <RainbowButton
                      key={index}
                      onClick={() => {
                        if (index === 0) setMessage(answers.prenom);
                        if (index === 1) setMessage(answers.age);
                        if (index === 2) setMessage(answers.parcours);
                        if (index === 3) setMessage(answers.passion);
                      }}
                      className="text-xs px-2 py-2 lg:text-base md:px-12 lg:px-15 lg:py-3 rounded-xl text-white transition hover:scale-[1.03] whitespace-nowrap"
                    >
                      {question}
                    </RainbowButton>
                  ))}
                </div>

                <div className="relative flex justify-center items-center mt-6 md:mt-8 lg:mt-10">
                    <Avatar3D />
                </div>

              </div>

                <div
                  className={
                    "w-full max-w-md mx-auto md:mx-0 md:ml-8 lg:ml-10"
                  }
                >

                    <div
                        className="relative bg-black/20 text-white p-3 md:p-5 lg:p-10 rounded-2xl shadow-lg backdrop-blur-xl">
                        <p className="whitespace-pre-line text-sm leading-relaxed">
                            <TypingAnimation
                                text={message}
                                className="text-xs md:text-sd lg:text-base leading-relaxed text-white"
                            />
                        </p>


                        <div
                          className="absolute w-0 h-0 -top-2.5 right-10
      border-l-10 border-r-10 border-b-10
      border-l-transparent border-r-transparent border-b-black/20
      md:hidden"
                        />

                        <div
                          className="absolute hidden md:block w-0 h-0 top-6 -left-2.5
      border-t-10 border-b-10 border-r-10
      border-t-transparent border-b-transparent border-r-black/20"
                        />
                    </div>
                </div>

            </div>

        </section>
    );
};

export default About;
