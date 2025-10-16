export const PaginationButton = ({ nbrButton = 0, handleClick }) => {
  // numbers sera un tableau de chiffres
  // Ex: si nbrButton = 5  ==> number sera égale à [1,2,3,4,5]

  const numbers = Array.from({ length: nbrButton }, (_, index) => index + 1);

  return (
    <>
      {numbers.map((n) => (
        <button onClick={() => handleClick(n)} className="btn mr-2">
          {n}
        </button>
      ))}
    </>
  );
};
