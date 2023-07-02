import React from 'react'
import AdminNavbar from '../Users/AdminNavbar'
import { useNavigate } from 'react-router-dom';
import { BackendBaseURL } from '../BackendUrl';
import { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';

const OrderComponent = () => {


  var [userName, setuserName] = useState("");
  const [orders, setorders] = useState([
    {
      id: "",
      totalItems: "",
      totalOrderPrice: "",
      orderCreatedOn: "",
      cartOwner: "",
      orderItems: "",
      placedOn: "",
      status: "",
      address: ""
    }
  ]);
  var navigate = useNavigate();

  //get all orders by useEffect
  useEffect(() => {
    axios.get(`${BackendBaseURL}/orders`).then((res) => {
      setorders(res.data)
    })
    console.log("All Orders!");
  }, []);


  var Remove = (no) => {
    axios.delete(`${BackendBaseURL}/order/deleteorder/id/${no}`)
      .then(response => {
        console.log(response.data);
      })
    var filterorder = orders.filter((order) => {
      return (order.id != no);
    });
    setorders(filterorder);
  }


  var Logout = () => {
    sessionStorage.removeItem("isLoggedIn");
    sessionStorage.removeItem("userName");
    navigate("/login");
}



  return (
    <div>
      <AdminNavbar />
      <div class="container mt-4">
        <div style={{ float: "right" }}>
          Welcome {" "} {userName} {" "}
          <button className='btn btn-primary'
            onClick={Logout}>
            Log out
          </button>
        </div>
        <figure class="text-center"><h1>MY ORDER LIST</h1></figure>

        <div className="row">
          <table className="table table-bordered shadow">
            <thead>
              <tr>
                <th>id</th>
                <th>totalItems</th>
                <th>totalOrderPrice</th>
                <th>orderCreatedOn</th>
                <th>cartOwner</th>
                {/* <th>orderItems</th> */}
                <th>placedOn</th>
                <th>status</th>
                {/* <th>address</th> */}
                <th>Delete</th>
                <th>update</th>
              </tr>
            </thead>
            <tbody>
              {
                orders.map((order) => {
                  return (
                    <tr key={order.id}>
                      <td>{order.id}</td>
                      <td>{order.totalItems}</td>
                      <td>{order.totalOrderPrice}</td>
                      <td>{order.orderCreatedOn}</td>
                      <td>{order.cartOwner.first_name}</td>
                      <td>{order.placedOn}</td>
                      <td>{order.status}</td>
                      <td>
                        <button className='btn btn-danger'
                          onClick=
                          {
                            () => {
                              Remove(order.id)
                            }
                          }>
                          Delete
                        </button>
                      </td>
                      <td>
                        <button type="button" class="btn btn-outline-warning">
                          <Link to={`/editorder/${order.id}`}>Edit</Link>
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
  )
}

export default OrderComponent