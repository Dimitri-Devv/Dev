import { useSelector } from "react-redux";
import { ProductCard } from "../components/ProductCard";

export const Cart = () => {
  const products = useSelector((state) => state.productCart.value);

  return (
    <section className="w-full grid grid-cols-4 gap-2">
      {products.map((p) => (
        <ProductCard product={p} />
      ))}
    </section>
  );
};
