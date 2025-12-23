import { Globe } from "@/components/ui/globe";
import {AuroraText} from "@/components/ui/titre.jsx";

const Contact = () => {
    return (

        <section
            id="contact"
            className="relative min-h-screen flex items-center justify-center px-6 py-24"
        >
            <div>
                <div className="w-full flex flex-col items-center text-center mb-20">
            <AuroraText>
                Contact
            </AuroraText>
                </div>


            <div className="relative z-10 w-full max-w-6xl grid grid-cols-1 lg:grid-cols-2 gap-16 items-center">


                {/* 📩 FORMULAIRE */}
                <div className="relative background-secondary p-8 lg:p-12 rounded-2xl shadow-xl">
                    <h2 className="text-3xl font-semibold textPrimary mb-6">
                        Me contacter
                    </h2>

                    <p className="textSecondary mb-8 text-sm leading-relaxed">
                        Une question, un projet ou juste envie d’échanger ?
                        N’hésite pas à m’écrire.
                    </p>

                    <form className="flex flex-col gap-4">
                        <input
                            type="text"
                            placeholder="Ton nom"
                            className="bg-black/30 border border-white/10 rounded-lg px-4 py-3 text-sm text-white placeholder:text-zinc-500 focus:outline-none focus:border-white/30"
                        />

                        <input
                            type="email"
                            placeholder="Ton email"
                            className="bg-black/30 border border-white/10 rounded-lg px-4 py-3 text-sm text-white placeholder:text-zinc-500 focus:outline-none focus:border-white/30"
                        />

                        <textarea
                            rows={4}
                            placeholder="Ton message"
                            className="bg-black/30 border border-white/10 rounded-lg px-4 py-3 text-sm text-white placeholder:text-zinc-500 resize-none focus:outline-none focus:border-white/30"
                        />

                        <button
                            type="submit"
                            className="mt-4 relative overflow-hidden rounded-xl px-6 py-3 text-sm font-medium text-white
                                       bg-linear-to-r from-violet-600/80 to-emerald-500/80
                                       hover:from-violet-600 hover:to-emerald-500 transition"
                        >
                            Envoyer le message
                        </button>
                    </form>
                </div>

                {/* 🌍 GLOBE */}
                <div className="relative flex items-center justify-center h-105 lg:h-130">
                    <Globe className="opacity-80" />
                </div>

            </div>
            </div>
        </section>
    );
};

export default Contact;