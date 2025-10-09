export const FruitsListA = ({ products, afficherHorsSotck, searchValue }) => {
  return (
    <>
      {products
        .filter(
          (product) =>
            (product.stocked === false)
        )
        .map((p) => (
          <ul key={p.name}>
            <li>{p.name}</li>
            <li>catégorie: {p.category}</li>
            <li>Prix: {p.price}</li>

          </ul>
        ))}
    </>
  );
};