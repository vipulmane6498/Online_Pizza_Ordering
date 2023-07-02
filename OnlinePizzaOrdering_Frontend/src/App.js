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
import PageNotFoundComponent from './adminComponents/PageNotFoundComponent';



// Admin
import PizzasComponent from './adminComponents/PizzasComponent';

// import AdminNavbar from './AdminNavbar';
import AddProductComponent from './adminComponents/AddProductComponent';
import AddCategoryComponent from './adminComponents/AddCategoryComponent';
import DisplayCategoryComponent from './adminComponents/DisplayCategoryComponent';
import EditCategoryComponent from './adminComponents/EditCategoryComponent';
import EditProductComponent from './adminComponents/EditProductComponent';
import OfferDisplayComponent from './adminComponents/OfferDisplayComponent';
import AddOfferComponent from './adminComponents/AddOfferComponent';
import EditOfferComponent from './adminComponents/EditOfferComponent';
import ReviewDisplayComponent from './adminComponents/ReviewDisplayComponent';
import ReviewComponent from './adminComponents/ReviewComponent';
import AllUsersComponent from './adminComponents/AllUsersComponent';
import OrderComponent from './adminComponents/OrderComponent';
// import EditOrderComponent from '../adminComponents/EditOrderComponent';
// import PizzasComponent from '../adminComponents/PizzasComponent';
// import OrderComponent from '../adminComponents/OrderComponent';
import EditOrderComponent from './adminComponents/EditOrderComponent';

//////////////////////////////////////////////////////////////////////////////////////////////////

function App() {
  return (
    // <>
    //    <NavBar />
    //    <AdminApp/>
    //     <Router>
    //       <Routes>
    //         {/* when user add wrong URL  */}
    //         {/* <Route  path='/*' element={<PageNotFoundComponent />}></Route> */}

    //         <Route path="/" element={<HomePage />} />   {/* without loggedIn homepage */}

    //         <Route path="/aboutus" element={<AboutUs />} />
    //         {/* <Route path="/aboutus" element={<AboutUs />} /> */}

    //         <Route path="/contactus" element={<ContactUs />} />
    //         <Route path='/register' element={<Register/>} />
    //         <Route path="/login" element={<Login/>} />
    //         <Route path="/allpizza" element={<HomePage />} /> {/* after loggedIn homepage we provide diff url path*/}
    //         {/* <Route path="/adminhome" element={<PizzasComponent/>}></Route> */}
    //       </Routes>
    //     </Router>
    //     </>
    <>
      {/* <AdminNavbar/> */}
      <NavBar />
      <Router>
        <Routes>

          {/* when user add wrong URL  */}
          {/* <Route  path='/*' element={<PageNotFoundComponent />}></Route> */}

          <Route path="/" element={<HomePage />} />   {/* without loggedIn homepage */}

          <Route path="/aboutus" element={<AboutUs />} />
          {/* <Route path="/aboutus" element={<AboutUs />} /> */}

          <Route path="/contactus" element={<ContactUs />} />
          <Route path='/register' element={<Register />} />
          <Route path="/login" element={<Login />} />
          <Route path="/allpizza" element={<HomePage />} /> {/* after loggedIn homepage we provide diff url path*/}
          <Route path="/adminhome" element={<PizzasComponent />}></Route>

          {/* /////////////////////////////////////////////////////////////////////////////////////// */}

          {/* adminhome */}
          <Route path="/adminhome" element={<PizzasComponent />}></Route>
          {/* category */}
          <Route path="/displaycategories" element={<DisplayCategoryComponent />}></Route>
          <Route path="/adminaddcategory" element={<AddCategoryComponent />}></Route>
          <Route path="/admineditcategory/:id" element={<EditCategoryComponent />}></Route>
          {/* pizza */}
          <Route path="/adminpizzas" element={<PizzasComponent />}></Route>
          <Route path="/adminaddproduct" element={<AddProductComponent />}></Route>
          <Route path="/admineditproduct/:id" element={<EditProductComponent />}></Route>
          {/* offer */}
          <Route path="/adminofferdisplay" element={<OfferDisplayComponent />}></Route>
          {/* need to add code in AddOfferComponent */}
          <Route path="/adminaddoffer" element={<AddOfferComponent />}></Route>
          <Route path="/admineditoffer/:id" element={<EditOfferComponent />}></Route>
          <Route path="/adminreviews" element={<ReviewDisplayComponent />}></Route>
          <Route path="/adminreview" element={<ReviewComponent />}></Route>
          <Route path="/adminusers" element={<AllUsersComponent />}></Route>
          <Route path="/adminorders" element={<OrderComponent />}></Route>
          <Route path="/editorder/:id" element={<EditOrderComponent />}></Route>


        </Routes>
      </Router>



      <Footer />
    </>
  );
}

export default App;
