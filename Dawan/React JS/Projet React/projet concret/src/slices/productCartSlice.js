import { createSlice } from "@reduxjs/toolkit";

export const productCartSlice = createSlice({
  name: "productCart",
  initialState: {
    value: [],
  },
  reducers: {
    addProduct: (state, action) => {
      const product = action.payload;

      if (state.value.find((p) => p.id === product.id)) return state;

      state.value.push(product);
    },
  },
});

export const { addProduct } = productCartSlice.actions;
export default productCartSlice.reducer;
