import React from "react";
import "./App.css";

function App() {
  const heading = "Office Space";

  const officeSpaces = [
     {
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: "https://images.pexels.com/photos/3184292/pexels-photo-3184292.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=600"
  },
  {
    name: "WeWork",
    rent: 65000,
    address: "Bangalore",
    image: "https://images.pexels.com/photos/5669602/pexels-photo-5669602.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=600"
  },
    {
      name: "Regus",
      rent: 58000,
      address: "Hyderabad",
      image: "https://images.unsplash.com/photo-1557804506-669a67965ba0?auto=format&fit=crop&w=600&q=60"
    }
  ];

  return (
    <div className="App">
      <h1>{heading}, at Affordable Range</h1>
      {officeSpaces.map((office, index) => {
        const rentColorClass = office.rent <= 60000 ? "textRed" : "textGreen";
        return (
          <div key={index} className="office-card">
            <img
              src={office.image}
              alt={`${office.name} Office`}
              className="office-img"
            />
            <h2>Name: {office.name}</h2>
            <h3 className={rentColorClass}>Rent: Rs. {office.rent}</h3>
            <h4>Address: {office.address}</h4>
          </div>
        );
      })}
    </div>
  );
}

export default App;


