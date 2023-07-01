import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { useNavigate, Link } from 'react-router-dom';
import { BackendBaseURL } from '../BackendUrl';
import AdminNavbar from '../Users/AdminNavbar';

const DisplayCategoryComponent = () => {

    const navigate = useNavigate();

    const[userName, setUserName] = useState("");
    const[category, setCategory] = useState([]);


    //To get all categories
    useEffect( () => {
        const getCategory= async () =>{
            const reqData = await fetch(`${BackendBaseURL}/allcategories`);
            const resData=await reqData.json();
            setCategory(resData);
            console.log(reqData);
        }
        getCategory();

    },[])


    //to delte category
    var Remove = (id) => {
        axios.delete(`${BackendBaseURL}/category/id/${id}`);

        var filterCategory = category.filter((category)=>{
            return (category.id !== id);
        });
        setCategory(filterCategory);

    }
////////////////////////////////////////////////////////////////////////////////////////////
    var EditCategory = (id) => {
        window.location.href =`http://localhost:3000/admineditcategory/${id}`;
       }
//////////////////////////////////////////////////////////////////////////////////////////////////
    var Logout = ()=>{
        sessionStorage.removeItem("isLoggedIn");
        sessionStorage.removeItem("userName");
       navigate("/login");
    }
    return (
        <>
        <div>
        <AdminNavbar/>
                <div className="container">
                    <div className="row">
                        <div className="col-md-12">
                            <figure class="text-center"><h1>ALL CATEGORIES</h1></figure>
                            <div style={{ float: "right" }}>
                                {/* <a href="http://localhost:3000/adminaddcategory" className="btn btn-info">ADD CATEGORY</a> */}
                                <Link to="/adminaddcategory" className="btn btn-info">ADD CATEGORY</Link>
                                Welcome {" "} {userName} {" "}
                                <button className='btn btn-primary'
                                    onClick={Logout}>
                                    Log out
                                </button>
                            </div>
                            <table className="table table-bordered shadow">
                                <thead>
                                    <tr >
                                        <th>Sr. No</th>
                                        <th>CategoryName</th>
                                        <th>Description</th>
                                        <th>DeleteCategory</th>
                                        <th>EditCategory</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    {category.map((category, index) => (
                                        <tr key={index}>

                                            <td>{index + 1}</td>
                                            <td>{category.categoryName}</td>
                                            <td>{category.description}</td>



                                            <td>
                                                <button className='btn btn-danger'
                                                    onClick=
                                                    {
                                                        () => {
                                                            Remove(category.id)
                                                        }
                                                    }>
                                                    Delete
                                                </button>
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-outline-warning" onClick={()=> EditCategory(category.id)}>
                                                   Edit
                                                </button>
                                            </td>
                                        </tr>
                                    )) 
                                    }
                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
       
        </div>
        </>
    )
}

export default DisplayCategoryComponent