import axios from 'axios';
import React, { useState } from 'react'
import { BackendBaseURL } from '../BackendUrl';
import { useNavigate } from 'react-router-dom';
import AdminNavbar from '../Users/AdminNavbar';

const AddCategoryComponent = () => {

const [id, setId] = useState();
const [categoryName, setCategoryName] = useState();
const [description, setDescription] = useState();

const navigate = useNavigate();


async function save(event){
    event.preventDefault();
    try{
        await axios.post(`${BackendBaseURL}/addcategory`,{
            id: id,
            categoryName: categoryName,
            description: description

        }).then((res)=>{
            //201 => this is a http status from backend/postman if given data is in correct validation/input
            if(res.status === 201){
             alert("Category added successfully!");
                    navigate(`/displaycategories`);
                } else {
                    alert("Somethong went wrong!");

                }
        })
        .catch()
        // alert("Category successfully Added!")
        //when admin try to chnage the value of any cateogry then set() method thorugh it will be change
        setId("");
        setCategoryName("");
        setDescription("");   

        
        navigate("/displaycategories");
    }
    catch(err){
            console.log(err);
    }
}

  return (

<div>
    <AdminNavbar />


    <div className="container mt-4">
        <form>
        <div className="form-group">
            <label>CategoryName</label>
            <input type="text" className="form-control"placeholder="enter Category name"
            value={categoryName}
            onChange={(event)=>{
                setCategoryName(event.target.value);
            }}
            />
        </div>

        <div className="form-group">
            <label>description</label>
            <input type="text" className="form-control"placeholder="enter Description"
            value={description}
            onChange={(event)=>{
                setDescription(event.target.value);
            }}
            />
        </div>

        <button className="btn btn-primary mt-4" onClick={save}>Added</button>
        </form>
</div>
</div>
  )
}

export default AddCategoryComponent