import {BrowserRouter} from "react-router";
import Navbar from './components/navbar.jsx';
import Footer from './components/footer.jsx';
import Home from "./pages/Home.jsx"
import './App.css'

function App() {
  return (
        <BrowserRouter>
            <Navbar />
            <main>
                <Home/>
            </main>
            <Footer />
        </BrowserRouter>
  )
}

export default App;
