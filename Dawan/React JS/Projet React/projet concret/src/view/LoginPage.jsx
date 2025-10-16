import { useForm } from "react-hook-form";
import { useAuth } from "../hooks/useAuth";

export const LoginPage = () => {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm();

  const { login } = useAuth();

  const submit = (credential) => {
    login(credential);
  };

  return (
    <section>
      <h1>Forumaire de connexion</h1>
      <p>identifiants : admin / admin</p>
      <form className="form-group" onSubmit={handleSubmit(submit)}>
        <label htmlFor="login">Login</label>
        <input
          type="text"
          id="login"
          {...register("login", { required: "login obligatoire" })}
          aria-describedby="error-login"
          className="form-control"
        />
        <span className="login-message" aria-live="polite" id="error-login">
          {errors.title && <>{errors.title.message}</>}
        </span>
        <label htmlFor="password">Mot de passe</label>
        <input
          type="password"
          id="password"
          {...register("password", { required: "mdp obligatoire" })}
          aria-describedby="error-password"
          className="form-control"
        />
        <span className="text-red" aria-live="polite" id="error-password">
          {errors.title && <>{errors.title.message}</>}
        </span>
        <br />
        <button
          aria-label="Mettre à jour le produit"
          className="btn myButton mt-2"
          type="submit"
        >
          Se connecter
        </button>
      </form>
    </section>
  );
};
