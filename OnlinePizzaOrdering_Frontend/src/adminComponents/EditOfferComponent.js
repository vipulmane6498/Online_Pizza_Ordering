import React from 'react'
import { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { BackendBaseURL } from '../BackendUrl';
import axios from 'axios';
import AdminNavbar from '../Users/AdminNavbar';

const EditOfferComponent = () => {

    const [name, setName] = useState("");
    const [discount, setDiscount] = useState("");
    const [valid_upto, setValid_upto] = useState("");
    const [valid_from, setValid_from] = useState("");
    const [code, setCode] = useState("");
    const [terms_conditions, setTerms_conditions] = useState("");

    const navigate = useNavigate();
    const { id } = useParams();

    const updateOffer = async (e) => {
        e.preventDefault();
        console.log(id);
        debugger;
        // this.name = name;
        // this.discount = discount;
        // this.valid_upto = valid_upto;
        // this.valid_from = valid_from;
        // this.code = code;
        // this.terms_conditions = terms_conditions;
        await axios.put(`${BackendBaseURL}/editoffer`, {
            id: id,
            name: name,
            discount: discount,
            valid_upto: valid_upto,
            valid_from: valid_from,
            code: code,
            terms_conditions: terms_conditions,
        }).then((res)=> {
            if(res.status === 200 || res.data !== null){
                alert("Offer edited Successfully!");
                console.log("Offer edited Successfully! ");
            }
            else{
                alert("something went wrong!");
                console.log("something went wrong!");
            }
        }).catch((err)=> {console.log(err)});

        navigate("/adminofferdisplay");
    }

    useEffect(() => {
        getOfferById();
    }, []);


    const getOfferById = async () => {
        debugger;
        const response = await axios.get(`${BackendBaseURL}/offer/id/${id}`);

        debugger;
        setName(response.data.name);
        setDiscount(response.data.discount);
        setValid_upto(response.data.valid_upto);
        setValid_from(response.data.valid_from);
        setCode(response.data.code);
        setTerms_conditions(response.data.terms_conditions);
    }

    return (
        <div>
            <AdminNavbar/>
        <div>
            {/* <AdminNav/> */}
            <form onSubmit={updateOffer}>
                <div className="form-group">
                    <label className="label">name</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="name"
                        value={name}
                        onChange={(e) => setName(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">discount</label>
                    <input
                        className="form-control"
                        type="number"
                        placeholder="discount"
                        value={discount}
                        onChange={(e) => setDiscount(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">valid_upto</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="valid_upto"
                        value={valid_upto}
                        onChange={(e) => setValid_upto(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">valid_from</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="valid_from"
                        value={valid_from}
                        onChange={(e) => setValid_from(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">code</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="code"
                        value={code}
                        onChange={(e) => setCode(e.target.value)}
                    />
                </div>

                <div className="form-group">
                    <label className="label">terms_conditions</label>
                    <input
                        className="form-control"
                        type="text"
                        placeholder="terms_conditions"
                        value={terms_conditions}
                        onChange={(e) => setTerms_conditions(e.target.value)}
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

export default EditOfferComponent