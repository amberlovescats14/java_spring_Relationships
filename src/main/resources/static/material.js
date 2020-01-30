import M from 'materialize-css/js/select'
document.addEventListener('DOMContentLoaded', function() {
    let elems = document.querySelectorAll('select');
    let instances = M.FormSelect.init(elems, options);
});

console.log("JS FILE")