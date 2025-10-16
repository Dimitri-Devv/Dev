import { useDispatch, useSelector } from "react-redux";
import {
  decrement,
  increment,
  incrementByAmount,
} from "../slices/counterSlice";

export const Homepage = () => {
  // Avec les store, les sélecteurs permettent de "récupérer" nos états
  const count = useSelector((state) => state.count.value);

  // Avec les stores, on doit forcément passer par une méthode 'dispatch'
  // pour accéder à nos méthodes reducers
  const dispatch = useDispatch();

  const incrementCount = () => {
    dispatch(increment());
  };

  const incrementCount10 = () => {
    dispatch(incrementByAmount(10));
  };

  return (
    <>
      <h1>Exemple Redux</h1>
      <p>
        Pour s'abonner à un état de mon store Redux, je peux utiliser
        'useSelector'
      </p>
      <div className="w-fit m-auto">
        <p>Compteur: {count}</p>
        <button className="btn" onClick={incrementCount}>
          +
        </button>
        <button className="btn" onClick={() => dispatch(decrement())}>
          -
        </button>

        <button className="btn" onClick={incrementCount10}>
          +10
        </button>
        <button className="btn" onClick={() => dispatch(incrementByAmount(5))}>
          +5
        </button>
      </div>
    </>
  );
};
