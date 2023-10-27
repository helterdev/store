import { useState, useEffect, useRef } from "react";

export const Results = ({ filteredProducts, search }) => {
  return filteredProducts.length ? (
    <section className="section-show-results">
      <div className="results-search">
        <table className="product-table">
          <thead>
            <tr>
              <th>Número de Identificación</th>
              <th>Nombre</th>
              <th>Precio por Unidad</th>
              <th>Precio por Mayor</th>
              <th>Cantidad</th>
              <th>Stock</th>
            </tr>
          </thead>
          <tbody>
            {filteredProducts.map((product) => (
              <tr key={product.id}>
                <td>{product.id}</td>
                <td>{product.name}</td>
                <td>${product.unitPrice}</td>
                <td>${product.wholesalePrice}</td>
                <td>{product.quantity}</td>
                <td>{product.stock}</td>
                <td>
                  <button className="btn-agregar">Agregar al ticket </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </section>
  ) : (
    <section className="section-show-results">
      <NoResults search={search} />
    </section>
  );
};

const NoResults = ({ search }) => {
  const isInputEmpty = useRef(true);

  useEffect(() => {
    isInputEmpty.current = search === "";
  }, [search]);

  return (
    <div className="no-results-container">
      {isInputEmpty.current ? (
        <p>
          Escribe el nombre/ID del producto que desea buscar...
        </p>
      ) : (
        <p>No se encontraron resultados</p>
      )}
    </div>
  )
};