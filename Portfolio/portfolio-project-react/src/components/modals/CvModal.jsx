export default function CvModal({ open, onClose }) {
    if (!open) return null;

    return (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black/70 backdrop-blur-sm">
            <div className="relative w-[90vw] h-[90vh] max-w-5xl rounded-xl bg-black overflow-hidden border border-white/10">

                {/* Close */}
                <button
                    onClick={onClose}
                    className="absolute top-3 right-3 text-white/70 hover:text-white text-xl"
                >
                    ✕
                </button>

                {/* PDF */}
                <iframe
                    src="/cv/CV-dev.pdf"
                    className="w-full h-full"
                    title="CV Dimitri Ricquier"
                />
            </div>
        </div>
    );
}