console.log("teacherClassUpload.js successfully loaded");
const showThumbnail = (event) => {
    alert("showThumbnail");
    const reader = new FileReader();
    reader.onload = (event) => {
        const imgTag = $("#class-image-thumbnail");
        imgTag.attr("src", event.target.result);
    }
    reader.readAsDataURL(event.target.files[0]);
}
