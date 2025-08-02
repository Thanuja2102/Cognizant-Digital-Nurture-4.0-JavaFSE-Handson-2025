import React, { useState } from 'react';
import './App.css';

function App() {
  const [count, setCount] = useState(0);
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('');

  // Increment function with multiple actions
  const handleIncrement = () => {
    setCount(count + 1);
    sayHello();
  };

  const sayHello = () => {
    alert('hello learner!');
  };

  const handleDecrement = () => {
    setCount(count - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = (event) => {
    alert('I was clicked');
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (currency.toLowerCase() === 'euro') {
      const euro = (amount / 90).toFixed(2); // assuming 1 Euro = 90 INR
      alert(`Converting to Euro: Amount is ${euro}`);
    } else if (currency.toLowerCase() === 'rupees') {
      const rupees = (amount * 90).toFixed(2);
      alert(`Converting to Rupees: Amount is ${rupees}`);
    } else {
      alert('Please enter a valid currency (Euro or Rupees)');
    }
  };

  return (
    <div className="App">
      <h2>{count}</h2>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={handleDecrement}>Decrement</button>
      <button onClick={() => sayWelcome('welcome')}>Say Welcome</button>
      <button onClick={handleClick}>Click on me</button>

      <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Amount:</label>
          <input
            type="number"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </div>
        <div>
          <label>Currency:</label>
          <input
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;


