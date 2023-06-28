import {
    BrowserRouter as Router,
    Routes,
    Route
} from 'react-router-dom';
import PizzasComponent from '../adminComponents/PizzasComponent';



const AdminApp = () => {
    return (
        <div>
            <Router>
                <Routes>
                    <Route path="/adminhome" element={<PizzasComponent />}></Route>
                </Routes>
            </Router>


        </div>
    )
}

export default AdminApp