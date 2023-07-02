import React from 'react'
import { useNavigate } from 'react-router-dom';
import { BackendBaseURL } from '../BackendUrl';
import axios from 'axios';
import { useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { useState } from 'react';
import AdminNavbar from '../Users/AdminNavbar';


const EditOrderComponent = () => {

    const navigate = useNavigate();
    const { id } = useParams();

    // const [id,setId]=useState('');
    const [totalItems,setTotalItems]=useState("");
    const [totalOrderPrice,setTotalOrderPrice]=useState("");
    const[orderCreatedOn,setOrderCreatedOn]=useState("");
    const[cartOwner,setCartOwner]=useState("");
    const[orderItems,setOrderItems]=useState("");
    const[placedOn,setPlacedOn]=useState("");
    const[status,setStatus]=useState("");
    const[address,setAddress]=useState("");


    const updateOrder = async (e) => {
        e.preventDefault(); 
        console.log(id);
        debugger;
        await axios.put(`${BackendBaseURL}/order/editorder`,{
            id:id,
            totalItems: totalItems,
            totalOrderPrice: totalOrderPrice,
            orderCreatedOn: orderCreatedOn,
            cartOwner: cartOwner,
            // orderItems : orderItems,
            placedOn  : placedOn,
            status  : status,
            // address  : address
        });
        navigate("/adminorders");
    }

    useEffect(() => {
        getOrderById();
    }, []);


    const getOrderById = async () => {
        debugger;
        const response = await axios.get(`${BackendBaseURL}/order/id/${id}`);
        // setId(response.data.id);
        // totalItems: totalItems,
        // totalOrderPrice: totalOrderPrice,
        // orderOreatedOn: orderOreatedOn,
        // cartOwner: cartOwner,
        // orderItems : orderItems,
        // placedOn  : placedOn,
        // status  : status,
        // address  : address
        setTotalItems(response.data.totalItems);
        setTotalOrderPrice(response.data.totalOrderPrice);
        setOrderCreatedOn(response.data.orderCreatedOn);
        setCartOwner(response.data.cartOwner);
       // setOrderItems(response.data.orderItems);
        setPlacedOn(response.data.placedOn);
        setStatus(response.data.status);
       // setAddress(response.data.address);
    }


  return (
    <div>
    <AdminNavbar/>
    <form onSubmit={ updateOrder }>
        <div className="form-group">
            <label className="label">Name</label>
            <input 
                className="form-control"
                type="number"
                placeholder="totalItems"
                value={ totalItems }
                onChange={ (e) => setTotalItems(e.target.value) }
            />
        </div>

        <div className="form-group">
            <label className="label">Price</label>
            <input 
                className="form-control"
                type="number"
                placeholder="totalOrderPrice"
                value={ totalOrderPrice }
                onChange={ (e) => setTotalOrderPrice(e.target.value) }
            />
        </div>

        <div className="form-group">
            <label className="label">OrderCreatedOn</label>
            <input 
                className="form-control"
                type="text"
                placeholder="orderOreatedOn"
                value={ orderCreatedOn }
                onChange={ (e) => setOrderCreatedOn(e.target.value) }
            />
        </div>

        <div className="form-group">
            <label className="label">CartOwner</label>
            <input 
                className="form-control"
                type="text"
                placeholder="cartOwner"
                value={ cartOwner.first_name }
                onChange={ (e) => setCartOwner(e.target.value) }
            />
        </div>

        {/* <div className="field">
            <label className="label">orderItems</label>
            <input 
                className="orderItems"
                type="text"
                placeholder="orderItems"
                value={ orderItems }
                onChange={ (e) => setOrderItems(e.target.value) }
            />
        </div> */}

        <div className="form-group">
            <label className="label">PlacedOn</label>
            <input 
                className="form-control"
                type="text"
                placeholder="placedOn"
                value={ placedOn }
                onChange={ (e) => setPlacedOn(e.target.value) }
            />
        </div>

        <div className="form-group">
            <label className="label">Order Status</label>
            <input 
                className="form-control"
                type="text"
                placeholder="status"
                value={ status }
                onChange={ (e) => setStatus(e.target.value) }
            />
        </div>

        {/* <div className="field">
            <label className="label">address</label>
            <input 
                className="address"
                type="text"
                placeholder="address"
                value={ address }
                onChange={ (e) => setAddress(e.target.value) }
            />
        </div> */}

        <div className="form-group">
            <button className="btn btn-primary mt-4">Update</button>
        </div>
    </form>
</div>
  )
}

export default EditOrderComponent