import React from 'react'
// import AdminNavbar from '../Users/AdminNavbar';
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { BackendBaseURL } from '../BackendUrl';
// import EditProductComponent from './EditProductComponent';
import AdminNavbar from '../Users/AdminNavbar';
import { Link } from 'react-router-dom';



//this is for cutomer + admin side




const PizzasComponent = () => {

  var [userName, setuserName] = useState("");
  const [allpizza, setAllPizza] = useState([
    {
      id: "",
      pizzaName: "",
      price: "",
      avg_rating: "",
      summary: "",
      inStock: "",
      pizzaCategory: {
        id: "",
        categoryName: "",
        description: ""
      },
      veg: ""
    }
  ]);

  const navigate = useNavigate();

  useEffect(() => {
    axios.get(`${BackendBaseURL}/pizzas`).then((res) => {

      setAllPizza(res.data)
    })
    console.log("This is pizza");
  }, []);

  var Remove = (no) => {
    axios.delete(`${BackendBaseURL}/deletepizza/id/${no}`);
    var filterPizza = allpizza.filter((pizza) => {
      return (pizza.id !== no);
    });
    setAllPizza(filterPizza);
  }

  var changeCategory = (id) => {
    axios.put(`${BackendBaseURL}/editpizza`);
  }

////////////////////////////////////////////////////////////////////////////////////////////
  var EditProduct = (id) => {
    // window.location.href =`http://localhost:3000/admineditproduct/${id}`;
    navigate(`/admineditproduct/${id}`);

}
////////////////////////////////////////////////////////////////////////////////////////////
  var Logout = () => {
    sessionStorage.removeItem("isLoggedIn");
    sessionStorage.removeItem("userName");
    navigate("/login");
  }


  return (

    <div>
      <AdminNavbar/>
    <div style={{ marginTop: "20px" }}>
      {/* <AdminNavbar />  */}
      <div className="container mt-4">
        <div style={{ float: "right" }}>
          <br></br>
          {/* <a href="http://localhost:3000/adminaddproduct" className="btn btn-info">Add Pizza</a> */}
          <Link to="/adminaddproduct" className="btn btn-info">Add Pizza</Link>

          {"  "}{"  "}{"  "}
          Welcome {" "} {userName} {" "}
          <button className='btn btn-primary'
            onClick={Logout}>
            Log out
          </button>
        </div>
        <br></br> 

        <figure className="text-center"><h1>MY PRODUCT LIST</h1></figure>
        {/* <br/> */}
        <hr/>
        <div className="row">
          <table className="table table-bordered shadow">
            <thead>
              <tr>
                <th>Sr.</th>
                <th>Name</th>
                <th>Price</th>
                <th>avg_rating</th>
                <th>summary</th>
                <th>inStock</th>
                {/* <th>pizzaCategory</th> */}
                {/* <th>reviews</th> */}
                <th>veg</th>
                <th>Action</th>
                <th>Update</th>
              </tr>
            </thead>
            <tbody>
              {
                allpizza.map((pizza) => {
                  return (
                    <tr key={pizza.id}>
                      <td>{pizza.id}</td>
                      <td>{pizza.pizzaName}</td>
                      <td>{pizza.price}</td>
                      <td>{pizza.avg_rating}</td>
                      <td>{pizza.summary}</td>
                      <td>{pizza.inStock ? 'Instock' : 'Out of Stock'}</td>
                      {/* <td>{pizza.reviews}</td> */}
                      <td>{pizza.veg ? 'Yes' : 'No'}</td>
                      <td>
                        <button className='btn btn-danger'
                          onClick=
                          {
                            () => {
                              Remove(pizza.id)
                            }
                          }>
                          Delete
                        </button>
                      </td>
                      <td>
                        <button type="button" className="btn btn-outline-warning" onClick={() => EditProduct(pizza.id)}>
                          Edit

                        </button>
                      </td>
                    </tr>
                  )
                })
              }
            </tbody>
          </table>
        </div>
      </div>
    </div>
    </div>
  )
}

export default PizzasComponent