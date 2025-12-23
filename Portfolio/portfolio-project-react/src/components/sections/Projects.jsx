import {AuroraText} from "@/components/ui/titre.jsx";
import { Card, CardContent } from "@/components/ui/card.jsx"
import {
    Carousel,
    CarouselContent,
    CarouselItem,
    CarouselNext,
    CarouselPrevious,
} from "@/components/ui/carousel"

const Projects = () => {
    return (
        <section>
            <div className="grid grid-cols-1 gap-6 lg:grid-cols-2 mb-30">
            <AuroraText className="text-center">
                Projets
            </AuroraText>
            <Carousel className="w-full max-w-3xl ">
                <CarouselContent className="-ml-1">
                    {Array.from({ length: 5 }).map((_, index) => (
                        <CarouselItem key={index} className="pl-1 md:basis-1/2 lg:basis-1/3">
                            <div className="p-1">
                                <Card>
                                    <CardContent className="flex aspect-square items-center justify-center p-6">
                                        <span className="text-2xl font-semibold">{index + 1}</span>
                                    </CardContent>
                                </Card>
                            </div>
                        </CarouselItem>
                    ))}
                </CarouselContent>
                <CarouselPrevious />
                <CarouselNext />
            </Carousel>
            </div>
        </section>
    );
}
export default Projects