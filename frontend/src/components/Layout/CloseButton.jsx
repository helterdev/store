export function CloseButton({handleLogout}){
  return (
    <div className="close-button-container">
      <button onClick={handleLogout} className="btn btn-danger">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="20"
          height="20"
          viewBox="0 0 24 24"
          id="x-icon"
        >
          <path
            stroke="white"
            stroke-width="2"
            d="M19 6.41L17.59 5 12 10.59 6.41 5 5 6.41 10.59 12 5 17.59 6.41 19 12 13.41 17.59 19 19 17.59 13.41 12 19 6.41z"
          />
        </svg>
      </button>
    </div>
  );
}