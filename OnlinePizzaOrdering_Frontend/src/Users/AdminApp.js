import {
    BrowserRouter as Router,
    Routes,
    Route
} from 'react-router-dom';
import PizzasComponent from '../adminComponents/PizzasComponent';
// import AdminNavbar from './AdminNavbar';
import AddProductComponent from '../adminComponents/AddProductComponent';
import AddCategoryComponent from '../adminComponents/AddCategoryComponent';
import DisplayCategoryComponent from '../adminComponents/DisplayCategoryComponent';
import EditCategoryComponent from '../adminComponents/EditCategoryComponent';
import EditProductComponent from '../adminComponents/EditProductComponent';
import OfferDisplayComponent from '../adminComponents/OfferDisplayComponent';
import AddOfferComponent from '../adminComponents/AddOfferComponent';
import EditOfferComponent from '../adminComponents/EditOfferComponent';
import ReviewDisplayComponent from '../adminComponents/ReviewDisplayComponent';
import ReviewComponent from '../adminComponents/ReviewComponent';
// import AllUsersComponent from '../adminComponents/AllUsersComponent';



const AdminApp = () => {
    return (
        <>
        {/* <AdminNavbar/> */}
            <Router>
                <Routes>

                {/* adminhome */}
                    <Route path="/adminhome" element={<PizzasComponent />}></Route>
                {/* category */}
                    <Route path="/displaycategories" element={<DisplayCategoryComponent />}></Route>
                    <Route path="/adminaddcategory" element={<AddCategoryComponent />}></Route>
                    <Route path="/admineditcategory/:id" element={<EditCategoryComponent/>}></Route>
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
                    {/* <Route path="/adminusers" element={<AllUsersComponent/>}></Route> */}


                </Routes>
            </Router>


        </>
    )
}

export default AdminApp