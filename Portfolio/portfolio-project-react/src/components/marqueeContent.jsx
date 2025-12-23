import { cn } from "@/lib/utils"
import { Marquee } from "@/components/ui/marquee"

const technologies = [
  { name: "Java", logo: "/logos/java.svg" },
  { name: "Spring Boot", logo: "/logos/springboot.svg" },
  { name: "React", logo: "/logos/react.svg" },
  { name: "JavaScript", logo: "/logos/javascript.svg" },
  { name: "MySQL", logo: "/logos/mysql.svg" },
  { name: "PostgreSQL", logo: "/logos/postgresql.svg" },
  { name: "Docker", logo: "/logos/docker.svg" },
  { name: "GitHub", logo: "/logos/github.svg" },
]

const firstRow = technologies.slice(0, technologies.length / 2)
const secondRow = technologies.slice(technologies.length / 2)

const TechCard = ({ name, logo }) => {
  return (
    <div
      className="flex h-28 w-28 items-center justify-center rounded-xl
      border border-white/10 bg-black/50 backdrop-blur-md
      transition hover:scale-105 hover:bg-black/60"
    >
      <img
        src={logo}
        alt={name}
        className="h-12 w-12 object-contain"
      />
    </div>
  )
}

export function MarqueeDemo() {
    return (
        <div className="relative flex w-full flex-col items-center justify-center overflow-hidden">
            <Marquee pauseOnHover className="[--duration:20s]">
                {firstRow.map((tech) => (
                    <TechCard key={tech.name} {...tech} />
                ))}
            </Marquee>
            <Marquee reverse pauseOnHover className="[--duration:20s]">
                {secondRow.map((tech) => (
                    <TechCard key={tech.name} {...tech} />
                ))}
            </Marquee>
            <div className="from-background pointer-events-none absolute inset-y-0 left-0 w-1/4"></div>
            <div className="from-background pointer-events-none absolute inset-y-0 right-0 w-1/4"></div>
        </div>
    )
}
