// fetch all users from REST API and set HTML content
const imageContainer = document.getElementById('image');
const imageFragment = document.createDocumentFragment();

let tmp_url = "/rest/posts/id/";
let href_words = window.location.href.split("/");
post_url = tmp_url.concat(href_words[4]);

console.log('User data retrieved from: ' + post_url);

async function setImage() {
    const response = await fetch(post_url);
    const postData = await response.json();

    const li = createElementFromHTML(
        '<img src="data:image/jpg;base64,'+ postData.image +'"class="row ml-auto mr-auto w-100 mw-100" alt=" ">'
    );

    imageFragment.appendChild(li);
    imageContainer.appendChild(imageFragment);
}

setImage();