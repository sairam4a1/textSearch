import TextField from "@mui/material/TextField";

const SearchBar = ({ setSearchQuery, setPosts }) => (
  <div className="search-box">
    <TextField
      id="search-bar"
      className="text"
      type="search" onClick={(e) => {
        if (e.target.value.length < 3) {
          let posts = [];
          setPosts(posts);
          setSearchQuery("");
        }
      }}
      onChange={(e) => {
        e.preventDefault();
        if (e.target.value.length >= 3) {
          setSearchQuery(e.target.value);
        } else {
          let posts = [];
          setPosts(posts);
          setSearchQuery("");
        }
      }}
      label="Enter a search word"
      variant="outlined"
      placeholder="Search..."
      size="small"
    />
  </div>
);
export default SearchBar;
