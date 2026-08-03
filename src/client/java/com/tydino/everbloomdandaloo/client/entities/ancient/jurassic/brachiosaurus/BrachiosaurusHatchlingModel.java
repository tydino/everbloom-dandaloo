package com.tydino.everbloomdandaloo.client.entities.ancient.jurassic.brachiosaurus;

import net.minecraft.client.animation.KeyframeAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.Identifier;

public class BrachiosaurusHatchlingModel extends EntityModel<BrachiosaurusRenderState> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Identifier.fromNamespaceAndPath("everbloomdandaloo", "brachiosaurus"), "main");

	private final ModelPart root;
	private final ModelPart egg;
	private final ModelPart butt;
	private final ModelPart body;
	private final ModelPart leftarm;
	private final ModelPart rightarm;
	private final ModelPart neckbase;
	private final ModelPart necktip;
	private final ModelPart head;
	private final ModelPart jaw;
	private final ModelPart eyes;

	final KeyframeAnimation idle;
	final KeyframeAnimation eat;
	final KeyframeAnimation walk;
	final KeyframeAnimation sitDown;
	final KeyframeAnimation sitting;
	final KeyframeAnimation standUp;
	final KeyframeAnimation blinking;

	final KeyframeAnimation leanOver;

	public BrachiosaurusHatchlingModel(ModelPart root) {
		super(root);
		this.root = root.getChild("root");
		this.egg = this.root.getChild("egg");
		this.butt = this.egg.getChild("butt");
		this.body = this.butt.getChild("body");
		this.leftarm = this.body.getChild("leftarm");
		this.rightarm = this.body.getChild("rightarm");
		this.neckbase = this.body.getChild("neckbase");
		this.necktip = this.neckbase.getChild("necktip");
		this.head = this.necktip.getChild("head");
		this.jaw = this.head.getChild("jaw");
		this.eyes = this.head.getChild("eyes");

		this.idle = BrachiosaurusHatchlingAnimations.idle.bake(root);
		this.eat = BrachiosaurusHatchlingAnimations.eating.bake(root);
		this.walk = BrachiosaurusHatchlingAnimations.walking.bake(root);
		this.sitDown = BrachiosaurusHatchlingAnimations.sittingdown.bake(root);
		this.sitting = BrachiosaurusHatchlingAnimations.sitting.bake(root);
		this.standUp = BrachiosaurusHatchlingAnimations.standingup.bake(root);
		this.blinking = BrachiosaurusHatchlingAnimations.blink.bake(root);

		this.leanOver = BrachiosaurusHatchlingAnimations.leandown.bake(root);
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition modelData = new MeshDefinition();
		PartDefinition modelPartData = modelData.getRoot();
		PartDefinition root = modelPartData.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition egg = root.addOrReplaceChild("egg", CubeListBuilder.create().texOffs(0, 55).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(0, 46).addBox(-4.0F, -2.0F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-4.5F, -6.0F, -4.5F, 9.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
		.texOffs(0, 30).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 22).addBox(3.0F, -8.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(14, 22).addBox(-4.0F, -8.0F, -3.0F, 1.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(18, 30).addBox(-4.0F, -8.0F, 3.0F, 8.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition butt = egg.addOrReplaceChild("butt", CubeListBuilder.create().texOffs(0, 12).addBox(-2.0F, -4.0F, -2.0F, 4.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 1.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition body = butt.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 2).addBox(-3.0F, -4.0F, -3.0F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition leftarm = body.addOrReplaceChild("leftarm", CubeListBuilder.create(), PartPose.offset(-2.0F, -2.0F, -1.0F));

		PartDefinition cube_r1 = leftarm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(16, 4).addBox(-2.0F, -1.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.1745F, 0.2618F, 0.0F));

		PartDefinition rightarm = body.addOrReplaceChild("rightarm", CubeListBuilder.create(), PartPose.offset(2.0F, -2.0F, -1.0F));

		PartDefinition cube_r2 = rightarm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 2).addBox(4.0F, -1.0F, -6.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, 0.0F, -0.1745F, -0.2618F, 0.0F));

		PartDefinition neckbase = body.addOrReplaceChild("neckbase", CubeListBuilder.create().texOffs(22, 17).addBox(-1.5F, -6.0F, -2.0F, 3.0F, 7.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.0F, 1.0F, -0.2618F, 0.0F, 0.0F));

		PartDefinition necktip = neckbase.addOrReplaceChild("necktip", CubeListBuilder.create().texOffs(28, 0).addBox(-1.0F, -7.0F, -1.5F, 2.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

		PartDefinition head = necktip.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 12).addBox(-2.0F, -3.0F, -3.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -1.5F));

		PartDefinition nose_r1 = head.addOrReplaceChild("nose_r1", CubeListBuilder.create().texOffs(31, 24).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, -2.0F, 0.3054F, 0.0F, 0.0F));

		PartDefinition topjaw_r1 = head.addOrReplaceChild("topjaw_r1", CubeListBuilder.create().texOffs(34, 20).addBox(-1.5F, -2.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, -3.0F, 0.3491F, 0.0F, 0.0F));

		PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.0F));

		PartDefinition cube_r3 = jaw.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(24, 14).addBox(-1.0F, -1.0F, -0.5F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 1.0F, 0.0F, 0.2618F, 0.0F, 0.0F));

		PartDefinition eyes = head.addOrReplaceChild("eyes", CubeListBuilder.create().texOffs(0, 6).addBox(2.05F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
				.texOffs(4, 6).addBox(-2.05F, -0.5F, -0.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.5F, -0.5F));
		return LayerDefinition.create(modelData, 48, 62);
	}

	@Override
	public void setupAnim(BrachiosaurusRenderState state) {
		super.setupAnim(state);

		if(state.blinkAnimationState.isStarted()){
			this.blinking.apply(state.blinkAnimationState, state.ageInTicks);
		}

		if(state.idleAnimationState.isStarted()){
			this.idle.apply(state.idleAnimationState, state.ageInTicks);
		}

		if(state.eatAnimationState.isStarted()){
			this.eat.apply(state.eatAnimationState, state.ageInTicks);
			this.leanOver.apply(state.leanDownAnimationState, state.ageInTicks);
		}

		if(state.sittingdownAnimationState.isStarted()){
			this.sitDown.apply(state.sittingdownAnimationState, state.ageInTicks);
		}
		if(state.sitAnimationState.isStarted()){
			this.sitting.apply(state.sitAnimationState, state.ageInTicks);
		}
		if(state.standingupAnimationState.isStarted()){
			this.standUp.apply(state.standingupAnimationState, state.ageInTicks);
		}

		this.walk.applyWalk(state.walkAnimationPos, state.walkAnimationSpeed, 6f, 18f);

		//head
		this.head.xRot = state.xRot * (float) (Math.PI / 180.0);
		this.head.yRot = state.yRot * (float) (Math.PI / 180.0);
	}
}