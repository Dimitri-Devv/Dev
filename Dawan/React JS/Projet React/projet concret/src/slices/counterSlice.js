import { createSlice } from "@reduxjs/toolkit";

export const counterSlice = createSlice({
  name: "counter",
  initialState: {
    value: 0,
  },
  reducers: {
    // state -> Valeur de l'état avant le déclenchement de la fonciton reducer
    increment: (state) => {
      // Avec les store, on n'est pas 'censé' modifier directement le state
      // Avec ReduxToolkit, nous pouvons le faire
      state.value += 1;
    },
    decrement: (state) => {
      state.value -= 1;
    },
    incrementByAmount: (state, action) => {
      // La valeur passée en paramètre est accessible via 'action.payload'
      // Exemple : dans mon composant si je fais : 'dispatch(incrementByAmount(10))'
      //    action.payload = 10

      const amount = action.payload;

      state.value += amount;
    },
  },
});

export const { increment, decrement, incrementByAmount } = counterSlice.actions;
export default counterSlice.reducer;
