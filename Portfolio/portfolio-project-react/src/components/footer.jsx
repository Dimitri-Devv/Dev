import { Button } from "@/components/ui/button.jsx";
import logo from "@/assets/logo.png";
import {
  GitHubLogoIcon,
  LinkedInLogoIcon,
} from "@radix-ui/react-icons";

const socials = [
    { icon: GitHubLogoIcon, href: "https://github.com/Dimitri-Devv?tab=repositories" },
    { icon: LinkedInLogoIcon, href: "https://www.linkedin.com/in/dimitri-ricquier-155b9a230/" },
];

const Footer = () => {
    return (
        <footer className="relative w-full background-secondary text-white pb-24">

            <div className="mx-auto max-w-6xl px-6 py-6 flex flex-col items-center gap-4 md:gap-6">

                <img
                    src={logo}
                    alt="Dimitri Ricquier"
                    className="h-20 w-auto opacity-90"
                />

                <div className="flex gap-5">
                    {socials.map(({ icon: Icon, href }, index) => (
                        <Button
                            key={index}
                            variant="ghost"
                            size="icon"
                            asChild
                            className="rounded-full bg-zinc-800 hover:bg-zinc-700"
                        >
                            <a href={href} target="_blank" rel="noreferrer">
                                <Icon className="h-6 w-6" />
                            </a>
                        </Button>
                    ))}
                </div>


                <p className="text-sm text-white">
                    © {new Date().getFullYear()} Dimitri Ricquier. Tous droits réservés.
                </p>
            </div>



        </footer>
    );
};

export default Footer;