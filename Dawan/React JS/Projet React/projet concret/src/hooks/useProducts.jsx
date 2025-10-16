import axios from "axios";

export const useProducts = () => {
  const instanceAxios = axios.create({
    baseURL: "http://localhost:3001/products",
  });

  // Injecter avec .use
  instanceAxios.interceptors.request.use((config) => {
    const token = sessionStorage.getItem("token"); // récup du token

    // Vérifier qu'on a bien un token
    if (token) {
      console.log("TOKEN INJECTE !!");
      config.headers["Authorization"] = `Bearer ${token}`;
    } else console.log("Pas de token");

    // Pour rajouter un délai lors de l'envoi de nos requêtes
    // new Promise((resolve) => setTimeout(() => resolve(config), 1000));

    return config;
  });

  const url = "http://localhost:3001/products";

  const getPaginate = (page, perPage) => {
    return instanceAxios.get(`${url}/?_page=${page}&_per_page=${perPage}`);
  };

  return { getPaginate };
};
