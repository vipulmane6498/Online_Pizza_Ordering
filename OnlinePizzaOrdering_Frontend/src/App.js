import './App.css';
// import Footer from './Layouts/Footer';
import NavBar from './Layouts/NavBar';
import {
  BrowserRouter as Router,
  Routes,
  Route
} from 'react-router-dom';
import AboutUs from './Pages/AboutUs';
import ContactUs from './Pages/ContactUs';
import HomePage from './Pages/HomePage';
import Footer from './Layouts/Footer';
import Login from './Pages/Login';
import Register from './Pages/Register';
import AdminApp from './Users/AdminApp';


function App() {
  return (
    <>
       <NavBar />
       <AdminApp/>
        <Router>
          <Routes>
            <Route path="/" element={<HomePage />} />   {/* without loggedIn homepage */}
            <Route path="/aboutus" element={<AboutUs />} />
            <Route path="/aboutus" element={<AboutUs />} />

            <Route path="/contactus" element={<ContactUs />} />
            <Route path='/register' element={<Register/>} />
            <Route path="/login" element={<Login/>} />
            <Route path="/allpizza" element={<HomePage />} /> {/* after loggedIn homepage we provide diff url path*/}
            {/* <Route path="/adminhome" element={<PizzasComponent/>}></Route> */}
          </Routes>
        </Router>
        <Footer />
    </>
  );
}

export default App;
