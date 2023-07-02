import React from 'react'
import { useState, useEffect } from 'react';
import { BackendBaseURL } from '../BackendUrl';
import { Alert } from '@mui/material';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import AdminNavbar from '../Users/AdminNavbar';


const AddProductComponent = () => {

    const [id, setId] = useState();
    const [name, setName] = useState();
    const [price, setPrice] = useState("");
    const [avg_rating, setAvg_rating] = useState("");
    const [summary, setSummary] = useState("");
    const [isVeg, setIsVeg] = useState("");
    // const[isNonVeg,setIsNonVeg]=useState("");
    const [pizzaCategory, setPizzaCategory] = useState("");
    const [category, setCategory] = useState([]);
    const [inStock, setInStock] = useState("");
    const [imagePath, setImagePath] = useState("");

const navigate= useNavigate();

    async function save(event) {

        event.preventDefault(); //to avoid default url

        try {
            await axios.post(`${BackendBaseURL}/addpizza`, {
                id: id,
                pizzaName: name,
                price: price,
                avg_rating: avg_rating,
                summary: summary,
                isVeg: isVeg,
                // isNonVeg: isNonVeg,
                pizzaCategory: pizzaCategory,
                inStock: inStock,
                imagePath: imagePath

            })
            .then((res)=>{
                            //201 => this is a http status from backend/postman if given data is in correct validation/input
                if(res.status===201)
                {
                    alert("Pizza added successfully!");
                    navigate(`/adminhome`);
                } else {
                    alert("Somethong went wrong!");

                }
            })
            .catch((e)=>{console.log(e)});

            // Alert("Product added succesfully!!");
            // when addmin chnage the product category details it will be changed through set() method
            setId("");
            setName("");
            setPrice("");
            setAvg_rating("");
            setSummary("");
            setIsVeg("");
            // setIsNonVeg("");
            setPizzaCategory("");
            setInStock("");
            setImagePath("");

            navigate("/adminhome")
        }
        catch (err) {
            console.log(err);
        }
    }

    const handleOptionChange = (event) => {
        debugger;
        const selectedCategory = category.find(cat => cat.categoryName === event.target.value);
        setPizzaCategory(selectedCategory);
    }

    useEffect(()=>{
        const getCategory=async()=>{
            const reqData=await fetch(`${BackendBaseURL}/allcategories`);
            const resData=await reqData.json();
            setCategory(resData);
            console.log(reqData);
        }
        getCategory();
    },[]);



    return (

        <div>
            <AdminNavbar/>

        <div className="container mt-4">
            <form>
                <div className="form-group">
                    <label>name</label>
                    <input type="text" className="form-control" placeholder="enter pizza name"
                        value={name}
                        onChange={(event) => {
                            setName(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>Price</label>
                    <input type="number" className="form-control" placeholder="enter Price"
                        value={price}
                        onChange={(event) => {
                            setPrice(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>Avg_rating</label>
                    <input type="number" className="form-control" placeholder="enter Rating"
                        value={avg_rating}
                        onChange={(event) => {
                            setAvg_rating(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>summary</label>
                    <input type="text" className="form-control" placeholder="enter Summary"
                        value={summary}
                        onChange={(event) => {
                            setSummary(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label className="label">Image Path</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="Image Path"
                        value={imagePath}
                        onChange={(e) => setImagePath(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label>IsVeg</label>
                    <input type="text" className="form-control" placeholder="enter veg or non-veg"
                        value={isVeg}
                        onChange={(event) => {
                            setIsVeg(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>pizzaCategory</label>
                    {/* <input type="text" className="form-control"placeholder="Select categories"
            value={pizzaCategory}
            onChange={(event)=>{
                setIsVeg(event.target.value);
            }}
            /> */}
                    <select id="dropdown" className="form-control" value={pizzaCategory} onChange={handleOptionChange}>
                        <option value="">Choose an category</option>
                        {category.map(categ => (
                            <option key={categ.id} value={categ.value}>{categ.categoryName}</option>
                        ))}
                    </select>

                </div>

                <div className="form-group">
                    <label>InStock</label>
                    <input type="text" className="form-control" placeholder="enter stock"
                        value={inStock}
                        onChange={(event) => {
                            setInStock(event.target.value);
                        }}
                    />
                </div>


                <button className="btn btn-primary mt-4" onClick={save}>Add Product</button>
            </form>
        </div>
        </div>
    )
}

export default AddProductComponent