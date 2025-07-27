import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css'; // Your existing styles
import App from './App';
import 'bootstrap/dist/css/bootstrap.min.css'; // ✅ Add this line here

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

