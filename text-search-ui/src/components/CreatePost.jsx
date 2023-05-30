import * as React from 'react';
import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Dialog from '@mui/material/Dialog';
import DialogActions from '@mui/material/DialogActions';
import DialogContent from '@mui/material/DialogContent';
import DialogTitle from '@mui/material/DialogTitle';
import { useState } from 'react';


export default function CreatePost({ isopen, handleDialogueOpen }) {
    const [post, setPost] = useState({ "author": "system" });
    const handleClose = () => {
        handleDialogueOpen(false);
    };

    const handleChange = (event) => {
        const value = event.target.value;
        setPost({ ...post, [event.target.name]: value })
    }
    const handleCreatePost = () => {
        fetch("http://localhost:8080/post", options)
            .then(response => response.json())
            .then(res => {
                if (res.httpCode === 201) {
                    handleClose();
                } else {
                    alert(res?.message);
                }
            })
            .catch(error => {
                // Handle any errors
                console.error('Error:', error);
            });
    };
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(post)
    };

    return (
        <div>
            <Dialog open={isopen} onClose={handleClose}>
                <DialogTitle>Create Post</DialogTitle>
                <DialogContent>
                    <TextField autoFocus margin="dense" id="name"
                        label="Name" fullWidth variant="standard" required
                        name="name"
                        value={post?.name} onChange={handleChange} />
                    <TextField id="description"
                        label="Description" margin="dense" required
                        name="description" value={post?.description}
                        fullWidth multiline
                        onChange={handleChange} />
                </DialogContent>
                <DialogActions>
                    <Button onClick={handleClose}>Cancel</Button>
                    <Button onClick={handleCreatePost}>Create</Button>
                </DialogActions>
            </Dialog>
        </div>);
}