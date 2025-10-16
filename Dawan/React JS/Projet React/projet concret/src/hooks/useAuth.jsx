export const useAuth = () => {
  // REMPLACER PAR UNE LOGIQUE AVEC UN SERVEUR BACK
  const fakeLogin = (credential) => {
    if (credential.login === "admin" && credential.password === "admin") {
      return { token: "TOKEN_BACK" };
    } else false;
  };

  const login = (credential) => {
    const response = fakeLogin(credential);

    if (response) {
      sessionStorage.setItem("token", response.token); // accessible que sur l'obglet sur lequel on se trouve
      // localStorage.setItem("token", response.token); // accessible partout, du moment qu'on reste sur le mm navigateur
      return true;
    } else throw new Error("Bad credentials");
  };

  return { login };
};
