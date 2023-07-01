import React from 'react'
import AdminNavbar from '../Users/AdminNavbar';
import axios from 'axios';
import { useState, useEffect } from 'react';
import { BackendBaseURL } from '../BackendUrl';

//this is add review component for customer side

const ReviewComponent = () => {

    const [id, setId] = useState('');
    const [review, setReview] = useState("");
    const [rating, setRating] = useState("");



    async function save(event)
    {
        event.preventDefault();
    try
        {
         await axios.post(`${BackendBaseURL}/addreview`,
        {
        review: review,
        rating: rating,
        user: {
            id: 7,
            first_name: "Onkar",
            last_name: "Mahamuni",
            email: null,
            password: "abc",
            mobile_no: null,
            userRole: "CUSTOMER"
        },
        pizza: {
            id: 3,
            pizzaName: "mrudulla",
            price: 784.0,
            avg_rating: 3.8,
            summary: "extra large",
            inStock: false,
            pizzaCategory: null,
            veg: false
        }
        
        }).then((res)=>{
            if(res.status === 201){
                alert("Review added Successfully!");
                console.log("Review added Successfully!");
            }
            else{
                alert("Something went wrong");
                console.log("Something went wrong");
            }

        });




          alert("successfull rating");
          setId("");
          setReview("");
          setRating("");
          
        
        
        }
    catch(err)
        {
          alert("rating unsuccessful");
          console.log(err);
        }
   }

    return (
        <div>
            <AdminNavbar />
            <div class="container mt-4">
                <form>
                    <div class="form-group">
                        <label>reviews</label>
                        <input type="text" class="form-control" placeholder="enter review"
                            value={review}
                            onChange={(event) => {
                                setReview(event.target.value);
                            }}
                        />
                    </div>

                    <div class="form-group">
                        <label>rating</label>
                        <input type="number" class="form-control" placeholder="enter rating"
                            value={rating}
                            onChange={(event) => {
                                setRating(event.target.value);
                            }}
                        />
                    </div>
                    <button class="btn btn-primary mt-4" onClick={save}>Reviews</button>
                </form>
            </div>
        </div>
    )
}

export default ReviewComponent