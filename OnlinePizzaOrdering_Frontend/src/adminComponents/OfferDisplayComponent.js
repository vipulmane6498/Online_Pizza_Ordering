import React from 'react'
import { useNavigate } from 'react-router-dom';
import { useState, useEffect } from 'react';
import { BackendBaseURL } from '../BackendUrl';
import axios from 'axios';
import { Link } from 'react-router-dom';
// import AdminNavbar from './AdminNavbar';
import AdminNavbar from '../Users/AdminNavbar';


const OfferDisplayComponent = () => {

    var [userName, setUserName] = useState("");
    const [allOffer, setAllOffer] = useState([
        {
            id: "",
            name: "",
            discount:"" ,
            valid_from: "",
            valid_upto:"" ,
            code: "",
            terms_conditions: ""
        }
    ]);
    var navigate = useNavigate();

    useEffect(()=>{
        getOffers();
    }, []);

    var getOffers=async()=>{
        try{
        axios.get(`${BackendBaseURL}/showalloffers`).then((res) =>{
            
        setAllOffer(res.data)
        console.log("This is Offer");
        console.log(res.data)
         })
        }catch(e){
            console.log(e)
        }
    }

    var  Remove=(no)=>{
        axios.delete(`${BackendBaseURL}/deleteoffer/id/${no}`);
        var filterOffer = allOffer.filter((offer)=>{
                                    return (offer.id !== no);
                                });
        setAllOffer(filterOffer);
    }

    var EditOffer = (id) => {
        window.location.href =`http://localhost:3000/admineditoffer/${id}`;
    }

    var Logout = ()=>{
        sessionStorage.removeItem("isLoggedIn");
        sessionStorage.removeItem("userName");
        navigate("/login");
    }

  return (
    <div>
        
        <AdminNavbar/>
        <div class="container mt-4">
        <div style={{float: "right"}}>
       
        {/* <a href="/adminaddoffer" className="btn btn-info">ADD OFFER</a> */}
        <Link to="/adminaddoffer" className="btn btn-info">ADD OFFER</Link>
        
 Welcome {" "} {userName} {" "}
 <button className='btn btn-primary' 
         onClick={Logout}>
     Log out
 </button>
</div>
<figure class="text-center"><h1>MY ALL OFFERS</h1></figure>
            <div className="row">
                <table className="table table-bordered shadow">
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>name</th>
                            <th>discount</th>
                            <th>valid_upto</th>
                            <th>valid_from</th>
                            <th>code</th>
                            <th>terms_conditions</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            allOffer.map((offer)=>{
                                return(
                                    <tr key = {offer.id}>
                                    <td>{offer.id}</td>
                                    <td>{offer.name}</td>
                                    <td>{offer.discount}</td>
                                    <td>{offer.valid_upto}</td>
                                    <td>{offer.valid_from}</td>
                                    <td>{offer.code}</td>
                                    <td>{offer.terms_conditions}</td>
                                    <td>
                                    <button className='btn btn-danger'
                                                onClick=
                                                    {
                                                    ()=>{
                                                            Remove(offer.id)
                                                        }
                                                    }>
                                                    Delete
                                                </button>
                                    </td>
                                    <td>
                                    <button type="button" class="btn btn-outline-warning" onClick={()=> EditOffer(offer.id)}>
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

  )
}

export default OfferDisplayComponent