
import './App.css'
import {useState, useEffect} from "react";

function App() {

    const [isLogged, setIsLogged] = useState(false);
    const [isLoading, setIsLoading] = useState(false);

    useEffect(() => {
        if(isLogged){
            console.log("Il est connecté");
        }else{
            console.log("Il n'est pas connecté");
        }
    }, [isLogged]);

    const handleLogout = () => {
        setIsLogged(false);
    }

    const handleLogin = () => {
        setIsLoading(true);
        setTimeout(()=>{
            setIsLogged(true);
            setIsLoading(false);
        }, 1000)
    }
    if(isLoading){
        return(
            <p>Chargement..</p>
        )
    }
  return (
      <nav>
          <div>
              {isLogged ? (<button>Profil</button>) : null}
              <button onClick={isLogged ?  handleLogout : handleLogin}>{isLogged ? "Deconnecté" : "Connecté"}</button>


          </div>
      </nav>

  )
}

export default App
