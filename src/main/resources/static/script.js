function checkFiles(files) {
    console.log(files);

    if (files.length !== 1) {
        alert("Please upload exactly one file.");
        return;
    }

    const fileSize = files[0].size / 1024 / 1024; // in MiB
    if (fileSize > 10) {
        alert("File too large (max 10 MB).");
        return;
    }

    const answerPart = document.getElementById("answerPart");
    const preview = document.getElementById("preview");
    const answer = document.getElementById("answer");
    answerPart.style.display = "block";
    const file = files[0];

    // Preview
    if (file) {
        preview.src = URL.createObjectURL(file);
        preview.classList.add('animated', 'fadeIn');
    }

    // Upload
    const formData = new FormData();
    formData.append("image", file);

    fetch('/analyze', {
        method: 'POST',
        body: formData
    })
    .then(response => response.text())
    .then(text => {
        answer.innerHTML = text;
        answer.classList.add('alert', 'alert-success', 'animated', 'fadeIn');
    })
    .catch(error => {
        console.error("Error:", error);
        answer.innerHTML = "Error during analysis.";
        answer.classList.add('alert', 'alert-danger', 'animated', 'fadeIn');
    });
}
