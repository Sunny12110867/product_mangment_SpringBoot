import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
  const [product, setProduct] = useState({
    productName: '',
    description: '',
    price: 0,
    status: ''
  });
  const [show, setShow] = useState(false);
  const [products, setProducts] = useState([]);

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setProduct({ ...product, [name]: value });
  };

  const uploadProduct = () => {
    axios.post("http://localhost:8080/save", product)
      .then(response => {
        console.log('Product saved successfully', response);
        fetchProducts();
      })
      .catch(error => {
        console.error('There was an error saving the product', error);
      });
  };

  const fetchProducts = () => {
    axios.get("http://localhost:8080")
      .then(response => {
        setProducts(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the products!', error);
      });
  };

  useEffect(() => {
    fetchProducts();
  }, []);

  return (
    <div className="App">
      <button onClick={() => setShow(!show)}>Add New</button>

      {show && (
        <>
          <h1>Product Input</h1>
          <input
            type="text"
            name="productName"
            value={product.productName}
            onChange={handleInputChange}
            placeholder="Enter product name"
          />
          <input
            type="text"
            name="description"
            value={product.description}
            onChange={handleInputChange}
            placeholder="Enter description"
          />
          <input
            type="number"
            name="price"
            value={product.price}
            onChange={handleInputChange}
            placeholder="Enter price"
          />
          <input
            type="text"
            name="status"
            value={product.status}
            onChange={handleInputChange}
            placeholder="Enter status"
          />
          <button onClick={uploadProduct}>Save Product</button>
        </>
      )}

      <DisplayProduct products={products}  />
    </div>
  );
}

function DisplayProduct({ products }) {
  return (
    <div>
      <h2>All Products</h2>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            <p>Name: {product.productName}</p>
            <p>Description: {product.description}</p>
            <p>Price: {product.price}</p>
            <p>Status: {product.status}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
