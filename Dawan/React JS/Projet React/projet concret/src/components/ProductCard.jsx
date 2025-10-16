import { useDispatch } from "react-redux";
import { addProduct } from "../slices/productCartSlice";

export const ProductCard = ({ product }) => {
  const dispatch = useDispatch();

  const addInCart = () => {
    dispatch(addProduct(product));
  };

  return (
    <div className="flex shadow-xl card bg-base-100 w-96">
      <figure>
        <div className="h-40">
          <img src={product.image} alt={product.title} />
        </div>
      </figure>
      <div className="card-body">
        <h2 className="card-title">{product.title}</h2>
        <p>{product.category}</p>
        <p>{product.description}</p>
        <p>{product.price}</p>
        <div className="justify-end card-actions">
          <button className="btn btn-primary">Voir</button>
          <button onClick={addInCart} className="btn btn-primary">
            Ajouter au panier
          </button>
        </div>
      </div>
    </div>
  );
};
