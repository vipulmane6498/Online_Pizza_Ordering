import React from 'react'
import { BackendBaseURL } from '../BackendUrl';
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react'; 
import { useNavigate } from 'react-router-dom';
import { useParams } from 'react-router-dom';
import AdminNavbar from '../Users/AdminNavbar';


const EditCategoryComponent = () => {

    // const [id,setId]=useState('');
    const [categoryName, setCategoryName] = useState("");
    const [description, setDescription] = useState("");

    const navigate = useNavigate();
    const {id} = useParams();

    const updateCategory = async (event) => {
        event.preventDefault();
        console.log(id);
        debugger;
       
            await axios.put(`${BackendBaseURL}/editcategory`, {
                id: id,
                categoryName: categoryName,
                description: description,
            }).then((res) => {
                if (res.status === 200 || res.data !== null ) {
                    // debugger;
                    alert("category updated successfully");
                    console.log("category updated successfully");

                } else {
                    alert("Could not be updadated category");
                    console.log("Could not be updated category");
                }
            }).catch ((e)=>{console.log(e)})
            ;
        navigate("/displaycategories");
    }

    useEffect(() => {
        getCategoryById();
    }, []);

    const getCategoryById = async () => {
        //debugger;
        const response = await axios.get(`http://localhost:8080/pizzaordering/category/id/${id}`)
        .then((response)=>{setCategoryName(response.data.categoryName);
        setDescription(response.data.description);})
        .catch((e)=>{console.log(e)});
    }

    return (
        <div>
            <AdminNavbar/>
        <div>
            <form onSubmit={updateCategory}>

                <div className="form-group">
                    <label className="label">categoryName</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="categoryName"
                        value={categoryName}
                        onChange={(e) => setCategoryName(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">description</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="description"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                </div>



                <div className="form-group">
                    <button className="btn btn-primary mt-4">Update</button>
                </div>
            </form>
        </div>
        </div>
    )
}

export default EditCategoryComponent