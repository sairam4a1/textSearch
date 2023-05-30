import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import dateFormat from 'dateformat';
import HighlightMatchedContent from './HighlightMatchedContent'

const card = (post, searchQuery) => (
  <CardContent>
    <Typography variant="h5" component="div">
      <HighlightMatchedContent content={post?.name} searchString={searchQuery}></HighlightMatchedContent>
    </Typography>
    <Typography sx={{ mb: 1.5 }} color="text.secondary">
        {dateFormat(post?.createdAt, "mmmm dS, yyyy")}
    </Typography>
    <Typography variant="body2">
    <HighlightMatchedContent content={post?.description} searchString={searchQuery}></HighlightMatchedContent>

    </Typography>
  </CardContent>
);

const PhoneCard = ({ post, searchQuery }) => (
  <div style={
    { marginBottom: "30px" }
  }>
    <Card sx={{ maxWidth: 345 }}>{card(post, searchQuery)}</Card>
  </div>
);
export default PhoneCard;