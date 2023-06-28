import React, { useState } from 'react'
import {
  MDBInput,
  MDBCol,
  MDBRow,
  MDBBtn,
  MDBIcon
} from 'mdb-react-ui-kit';

import axios from 'axios';
// import { useNavigate } from 'react-router-dom';


//Flow to write a code of Register: =>
// 1.create component: Register.js
// 2. add registration form in return()
// 3. add useState hook: for each input for initalize and update the values of users;
// 4. create a function to save the user <datalist>
// 5. when user update/change any value for that add onChange event in form
// 6. add onClick{onSubmit} to sign up button to save the data
// 5. do routing in app.js
// 6. add call its url wherever required


const Register = () => {

  // const navigate = useNavigate;

  const hostName = "http://localhost:8080/pizzaordering";

  //useState: To set the the current state and update the value using set
  const [id, setId] = useState('');
  const [firstname, setFirstName] = useState("");
  const [lastname, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [mobile, setMobile] = useState("");
  const [userRole, setUserRole] = useState("");


  //save function: once the data has been filled by user need to submit
  const save = async (event) => {
    event.preventDefault(); //to avoid default url pattern
    try {
      // const result = await axios.get("http://localhost:8080/pizzaordering/register")

      await axios.post(`${hostName}/register`, {
        //assign frontend user data to backend with backend variables
        first_name: firstname,
        last_name: lastname,
        email: email,
        password: password,
        mobile_no: mobile,
        userRole: ("CUSTOMER", "ADMIN")

      });
      alert("Registration Successfully Done!!") //

      //set(change value) => if any value will change then it will be set through set() method
      setId("");
      setFirstName("");
      setLastName("");
      setEmail("");
      setPassword("");
      setMobile("");
      setUserRole("");
    }
    catch (err) {
      console.log("Error: " + err);
      alert("Registration Failed");
    }

  }


  return (

    <div className="container shadow bordered" style={{ marginBottom: "35px", marginTop: "35px", width: "600px", borderRadius: "10px" }}>
      <br />
      <h2 style={{ "margin": "10px", textAlign: 'center' }}>Registration</h2>
      <br />
      <form>
        <MDBRow className='mb-4'>
          <MDBCol>
            <MDBInput id='form3Example1' name='firstname' placeholder='First Name' value={firstname}

              onChange={(event) => {
                setFirstName(event.target.value);
              }}
            />
          </MDBCol>

          <MDBCol>
            <MDBInput id='form3Example2' name='Last Name' placeholder='Last Name' value={lastname}
              onChange={(event) => {
                setLastName(event.target.value);
              }}
            />
          </MDBCol>

        </MDBRow>

        <MDBInput className='mb-4' type='email' id='form3Example3' name='email' placeholder='Email Address' value={email}
          onChange={(event) => {
            setEmail(event.target.value);
          }}
        />

        <MDBInput className='mb-4' type='password' id='form3Example4' name='password' placeholder='Password' value={password}
          onChange={(event) => {
            setPassword(event.target.value);
          }}
        />

        <MDBInput className='mb-4' type='number' id='form3Example5' name='mobile' placeholder='mobile number' pattern="[0-9]]" title="Please enter a valid number"
          onChange={(event) => {
            setMobile(event.target.value);
          }}
        />

        <div style={{ margin: "10px" }}>
          <div class="dropdown">

            <div class="form-check">
              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1" checked />
              <label class="form-check-label" for="flexRadioDefault1">
                CUSTOMER
              </label>
            </div>
            <div class="form-check">
              <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault2" />
              <label class="form-check-label" for="flexRadioDefault2">
                ADMIN
              </label>
            </div>

          </div>
        </div>


        <button type='submit' className="white-text" style={{ width: "570px", height: "37.8px", border: 'none', borderRadius: "5px", backgroundColor: '#0275D8' }} onClick={save} >Sign Up</button>
        <div className='text-center'>
          <p>
            Already a member? <a href='http://localhost:3000/login'>Login</a>
          </p>
          <p>or sign up with:</p>,
          

          <MDBBtn floating color="secondary" className='mx-1'>
            <MDBIcon fab icon='facebook-f' />
          </MDBBtn>

          <MDBBtn floating color="secondary" className='mx-1'>
            <MDBIcon fab icon='google' />
          </MDBBtn>

          <MDBBtn floating color="secondary" className='mx-1'>
            <MDBIcon fab icon='twitter' />
          </MDBBtn>

          <MDBBtn floating color="secondary" className='mx-1'>
            <MDBIcon fab icon='github' />
          </MDBBtn>

        </div>
        <br />
      </form>
      <br />
    </div>

    // </div>

  );
}

export default Register

