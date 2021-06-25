const buttons = document.querySelectorAll("section .learnMore");
buttons.forEach(b => {
	b.addEventListener("click", e => {
		toggleLearnMore(e);
	});
});
function toggleLearnMore(e) {
	const content = e.target.parentElement.parentElement.children[2];
	content.classList.toggle("fade");
}
