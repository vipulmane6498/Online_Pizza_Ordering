import React from 'react'
import axios from 'axios';
import { useState } from 'react';
import { BackendBaseURL } from '../BackendUrl';
import { useNavigate } from 'react-router-dom';
import AdminNavbar from '../Users/AdminNavbar';

const AddOfferComponent = () => {

const navigate = useNavigate();


  const [id, setId] = useState();
  const [name, setName] = useState();
  const [discount, setDiscount] = useState("");
  const [valid_from, setValid_from] = useState("");
  const [valid_upto, setValid_upto] = useState("");
  const [code, setCode] = useState("");
  const [terms_conditions, setTerms_conditions] = useState("");



  async function save(event) {

    event.preventDefault(); //to avoid default url

    try {
        await axios.post(`${BackendBaseURL}/addoffer`, {
            id: id,
            name: name,
            discount: discount,
            valid_from: valid_from,
            valid_upto: valid_upto,
            code: code,
            terms_conditions:terms_conditions

        })
        .then((res)=>{
            if(res.status===201){
                alert("Offer added successfully!");
                navigate("/adminofferdisplay")
            }
            else{
                alert("Somethong went wrong!");
            }
        })
        .catch((err)=>{console.log(err);
        })

        // alert("Offer added succesfully!!");
        // when addmin chnage the product category details it will be changed through set() method
        setId("");
        setName("");
        setDiscount("");
        setValid_from("");
        setValid_upto("");
        setCode("");
        setTerms_conditions("");


        navigate("/adminofferdisplay");
      
    }
    catch (err) {
        console.log(err);
    }

    //not required
  //   const handleOptionChange = (event) => {
  //     debugger;
  //     const selectedOffer = offer.find(off => off.name === event.target.value);
  //     setCode(selectedOffer);
  // }

//   useEffect(()=>{
//     const getCategory=async()=>{
//         const reqData=await fetch(`${BackendBaseURL}/allcategories`);
//         const resData=await reqData.json();
//         setCategory(resData);
//         console.log(reqData);
//     }
//     getCategory();
// },[]);



}

  return (
    <div>
        <AdminNavbar/>
    <div className="container mt-4">
            <form>
                <div className="form-group">
                    <label>name</label>
                    <input type="text" className="form-control" placeholder="enter offer name"
                        value={name}
                        onChange={(event) => {
                            setName(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>discount</label>
                    <input type="number" className="form-control" placeholder="enter discount"
                        value={discount}
                        onChange={(event) => {
                          setDiscount(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>valid_from</label>
                    <input type="number" className="form-control" placeholder="enter starting date"
                        value={valid_from}
                        onChange={(event) => {
                          setValid_from(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>valid_upto</label>
                    <input type="text" className="form-control" placeholder="enter ending date"
                        value={valid_upto}
                        onChange={(event) => {
                          setValid_upto(event.target.value);
                        }}
                    />
                </div>

                <div className="form-group">
                    <label>code</label>
                    <input type="text" className="form-control" placeholder="enter code"
                        value={code}
                        onChange={(event) => {
                            setCode(event.target.value);
                        }}
                    />
                </div>
                <div className="form-group">
                    <label>terms_conditions</label>
                    <input type="text" className="form-control" placeholder="enter terms a& Conditions"
                        value={terms_conditions}
                        onChange={(event) => {
                          setTerms_conditions(event.target.value);
                        }}
                    />
                </div>

                <button className="btn btn-primary mt-4" onClick={save}>Add Product</button>
            </form>
        </div>
    </div>
  )
}

export default AddOfferComponent