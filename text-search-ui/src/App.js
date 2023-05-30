import './App.css';
import SearchBar from './components/SearchBar';
import { useState, useEffect } from 'react';
import PhoneCard from './components/PhoneCard';
import { Button } from '@material/react-button';
import CreatePost from './components/CreatePost';

function App() {
  const [searchQuery, setSearchQuery] = useState("");
  const [posts, setPosts] = useState([]);
  const [open, setOpen] = useState(false);
  useEffect(() => {
    if (searchQuery.length >= 3) {
      fetch("http://localhost:8080/post/" + searchQuery).then((response) => {
        return response.json()
      }).then((res) => {
        setPosts(res?.data);
        console.log((posts));
      }
      ).catch(error => {
        alert("Unable fetch the data")
      });
    }
  }, [searchQuery], []);

  const handleDialogueOpen = (flag)=>{
         setOpen(flag)
   }

  return (
    <div className='app'>
      <div>
      <h4 className='app-title'>Text Search</h4>
      </div>
      <div>
        <SearchBar setPosts={setPosts} setSearchQuery={setSearchQuery} />
        <Button id='create-post-button' variant="contained" onClick={handleDialogueOpen}>Create Post</Button>
        <CreatePost isopen={open} handleDialogueOpen={handleDialogueOpen}></CreatePost>
        <h5> {posts.length} post we found </h5>
        <CreatePost></CreatePost>
      </div>

      <div>
        {posts.map((post, index) => {
          return <PhoneCard post={post} searchQuery={searchQuery} key={index}></PhoneCard>}
        )}
      </div>
    </div>
  );
}
export default App;
