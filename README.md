# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

## Flix Part 2

### User Stories

#### REQUIRED (10pts)

- [x] (8pts) Expose details of movie (ratings using RatingBar, popularity, and synopsis) in a separate activity.
- [x] (2pts) Allow video posts to be played in full-screen using the YouTubePlayerView.

#### BONUS

- [ ] Implement a shared element transition when user clicks into the details of a movie (1 point).
- [ ] Trailers for popular movies are played automatically when the movie is selected (1 point).
  - [ ] When clicking on a popular movie (i.e. a movie voted for more than 5 stars) the video should be played immediately.
  - [ ] Less popular videos rely on the detailed page should show an image preview that can initiate playing a YouTube video.
- [ ] Add a play icon overlay to popular movies to indicate that the movie can be played (1 point).
- [ ] Apply data binding for views to help remove boilerplate code. (1 point)
- [ ] Add a rounded corners for the images using the Glide transformations. (1 point)

### App Walkthough GIF

`TODO://` Add the URL to your animated app walkthough `gif` in the image tag below, `YOUR_GIF_URL_HERE`. Make sure the gif actually renders and animates when viewing this README. (🚫 Remove this paragraph after after adding gif)

<img src="Walkthroughs/Part2Walkthorugh.gif" width=500><br>

### Notes

Describe any challenges encountered while building the app.

## Open-source libraries used
- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [x] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [x] (2pts) Improved the user interface by experimenting with styling and coloring.
   - [x]    Added Linear Gradient Background through Additional drawable resource file
   - [x]    Added non-scrolling "Now Showing" Heading to top of UI
   - [x]    Changed Text colours and font for better visibility and impact
   - [x]    Added padding between list items for a better organised feel

- [x] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

Main Walkthrough GIF - Runs through usage of application and shows the User-interface

<img src="Walkthroughs/MainWalkthrough.gif" width=500><br>

Orientation Response - Shows the change in less popular movie image displays upon orientation change. The poster image is shown in the portrait orientation and teh backdrop image is shown in the landscape orientation with text on the right in both.

<img src="Walkthroughs/OrientationResponse.gif" width=500><br>

Network Speed Placeholder - Shows the use of a placeholder graphic while teh movie image loads.

<img src="Walkthroughs/PlaceholderDemo.gif" width=500><br>

Heterogeneous RecyclerView - Shows the change in display style for popular and less popular movies. Popular movies with ratings of above 7 are shown with just their Title and Backdrop image in both orientations whereas less popular movies are displayed with poster image, title and overview in portrait or backdrop image, title and overview in landscape.

<img src="Walkthroughs/Popularity.gif" width=500><br>

### Notes
I had the most issues with the heterogenous recycler views as I initially used the the viewholder I defined for teh initial application's onCreate method. This caused errors in casting to a different viewholder type. Apart from that, I had some minor issues fetching and separating data from the Database as I had trouble deciphering teh returned key value pairs and had to go over the results for atleast 30 minutes to undertstand the various components and data values returned and thus debug my code.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
