import { configureStore } from "@reduxjs/toolkit";
import counterSlice from "./slices/counterSlice";
import productCartSlice from "./slices/productCartSlice";

export default configureStore({
  reducer: {
    count: counterSlice, // Attention, modifier l'import automatique !!
    productCart: productCartSlice,
  },
});
