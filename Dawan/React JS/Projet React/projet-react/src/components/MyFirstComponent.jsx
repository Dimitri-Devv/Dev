import ChildrenComponent from "./ChildrenComponent";

function MyFirstComponent() {

    const title = "Texte crée chez le parent"
    return (

    <section>
        <h1>Mon premier composant</h1>
        <ChildrenComponent text= {title} ></ChildrenComponent>
        <ChildrenComponent text={title} className="my-text" id="my-id">Ici les données de la prop children</ChildrenComponent>
        <Title>Mon titre</Title>
        </section>

        
    );
}

export default MyFirstComponent;

function Title({children}){
    return <h1 className="my-title">{children}</h1>;
}